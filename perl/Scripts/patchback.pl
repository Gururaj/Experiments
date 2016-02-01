#!/usr/bin/perl 

use strict;

use strict;
use Data::Dumper;

# Cannot handle files which needs added in. Might want to add that.

my $changelist = $ARGV[0];
if( ! defined $changelist or $changelist eq '') {
    die "Need a changelist to run";
}

my $cmd = "patch -p0 -i $changelist.patch";

print "Applying patch ... \n" .$cmd ."\n";

system($cmd);

open FILE,"cat $changelist.patch | grep '+++' | " or die "Cannot open patch file";

my @list = ();
while (my $line = <FILE>) {
    chomp $line;
    my @l = split /\s+/,$line;
    push @list,$l[1];
}

close(FILE);

my $fileList = join ' ',@list;

my $cmd = "svin changelist $changelist $fileList";
print "Creating changelist .. \n $cmd \n";
system($cmd);

