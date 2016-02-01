#!/usr/bin/perl

use POSIX qw(floor ceil);


my $arglength = scalar(@ARGV);

if($arglength == 0)
{
    die "Usage: perl $0 fileName MetricName Percentage\n";
}

my $fileName = $ARGV[0];

my $printHeaders = 0;
unless ($arglength >= 3)
{
    warn "Provide metric, percentage tolerance";
    $printHeaders = 1;
}

my $skip =4;

my $Esp = "Esp";
my $DB = "DB";

my $metric = "";
my $percentTolerance = 0;
my $limit = 0;
if($printHeaders == 1)
{
    print "Metrics are: \n";
}
else 
{
    $metric = $ARGV[1];
    $percentTolerance = $ARGV[2];
    $limit = $ARGV[3] if ($arglength > 3);
}


my $m1 = $metric . $Esp;
my $m2 = $metric . $DB;

my $firstLine = 1;
my $headers = {};

open FILE, "<" ,  $fileName or die $!;
my $isSpecial = ($m1 =~ /Cost/) ? 0 : 0;
while(my $line = <FILE>) 
{
    chomp $line;
    if($firstLine == 1) 
    {
        my @headers = split /,/,$line,-1;
        # process headers to get indexes. 
        my $idx = 0;
        for my $header (@headers)
        {
            chomp $header;
            if($printHeaders == 1 && $idx >=4 && $idx % 2 == 0)
            {   
                local $t = $header;
                $t =~ s/Esp$//;
                print $t . "\n" 
            }
            elsif($printHeaders == 0 && $idx < 4)
            {
                print $header. ",";
            }
            $headers->{$idx} = $header;
            $idx++;
        }
        $firstLine = 0;
        exit(0) if($printHeaders == 1);
        print "Espresso,DB,DB - Espresso,Percentage 100 * (DB-Espresso)/DB";
        print ",ImpressionDiff, ClickDiff" if ($isSpecial == 1);
        print "\n";
    }
    else 
    {
        # ignore records which do not contain all 4 keys
        next unless ( $line =~ /^\d+,\d+,\d+,\d+,/);
        # process each line, 
        # find out if there is any value in the requested metric 
        # If yes then do the difference.
        # IF it exceeds percent tolerant, then emit it.
        my @data = split /,/,$line,-1;
        my @key = @data[0..3];
        
        # print "Len" ,scalar(@data) . "\n";
        my $val1 = 0;
        my $val2 = 0;
        
        my $extraInfo = ();
        my $extra = "";
        my $correlated = 0;
        for (my $idx = $skip ; $idx < scalar(@data); $idx++)
        {            
            my $metric = $headers->{$idx};
           
            
            if($isSpecial == 1)
            {
                if($metric eq "ImpressionsEsp" or $metric eq "ImpressionsDB" or $metric eq "ClicksEsp" or $metric eq "ClicksDB")
                {
                    $extraInfo->{$metric} = $data[$idx];
                }                
            }            
            
            # print "$metric $m1 $m2 \n";
            if($metric eq $m1)
            {
                $val1 = $data[$idx];
            }
            if($metric eq $m2)
            {
                $val2 = $data[$idx];
            }
            if($isSpecial == 1)
            {
                $correlated = 0;
                my $impDiff = $extraInfo->{'ImpressionsDB'} - $extraInfo->{'ImpressionsEsp'};
                my $clkDiff = $extraInfo->{'ClicksDB'} - $extraInfo->{'ClicksEsp'};
                $extra = "," . $impDiff . "," . $clkDiff;
                $correlated = 1 if($impDiff == 0 and $clkDiff == 0);
            }
        }
        my $diff = 0;
        if($isSpecial == 0)
        {
            $diff = $val2 - $val1 
        }
        else
        {
            $diff = ceil($val2 * 1000.0) - ceil($val1 * 1000.0);
        }
        my $percent = 0;
        if($val2 != 0)
        {
            $percent = $diff * 100 / ceil($val2 * 1000)
        }
        if(abs($percent) > $percentTolerance && $val1 > $limit)
        {
            print join ",", @key if($correlated == 0); 
            if($isSpecial == 1)
            {
                if($correlated == 0)
                {
                print ",";
                printf ("%.3f", $val1/1000);
                print  ",";
                printf  ("%.3f",$val2/1000);
                printf  ",";
                printf ("%.3f",$diff/1000);
                print  ",";
                }
            }
            else 
            {
                print "," . $val1. "," . $val2 . "," . $diff . ",";
            }    
            printf("%.3f", $percent) if($correlated == 0); 
            print $extra if($correlated == 0); 
            print  "\n" if($correlated == 0);
        }
    }
}

