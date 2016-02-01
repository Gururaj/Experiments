#!/usr/bin/perl 

use strict;
use Data::Dumper;

my $changelist = $ARGV[0];
if( ! defined $changelist or $changelist eq '') {
    die "Need a changelist to run";
}

open FILE,'svin status |' or die "Cannot do svin status";
#open FILE,'cat t | ' or die "Cannot do svin status";

my $chReached = 'no';
my @list = ();
while(my $line = <FILE>) {

    chomp $line;        
    if($line =~ /\s+Changelist\s+\'$changelist\'/) {
        $chReached = 'yes';
        next;
    }
    
    if($chReached eq 'yes') {
        # collect all changes
        if ($line =~ /^\s*$/) {
            $chReached = 'no';
            next;
        }        
        my ($flag,$file) = split /\s+/,$line;
        push @list,$file;
    }
}

close(FILE);

my $filelist = join " ",@list;

my $cmd = "svin diff $filelist > $changelist.patch";

print "Getting diff .. \n".$cmd."\n";

system($cmd);

my $revert= "svin revert $filelist";

print "Reverting.. \n" .$revert;

system($revert);

system("svin status");

