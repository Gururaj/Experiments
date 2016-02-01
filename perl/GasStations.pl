#!/usr/bin/perl

use strict;
use warnings;


my @gasStation = (3,2,7,3,6,7,8,3,2);
my @distances = (1,6,2,3,8,2,6,7,7);

# my @arr = ();
# for(my $j =0; $j < scalar(@gasStation); $j++) {
#   $arr[$j] = $gasStation[$j] - $distances[$j];
# }

# print join " ",@arr;
# print  "\n";

sub max {
  my ($a,$b) = @_;
  return $a if($a >= $b);
  return $b;
}

my $maxSoFar = 0;
my $maxEndingHere = 0;
my $index = -1;

for(my $i = 0;$i < scalar(@gasStation); $i++) {
  if($maxEndingHere ==0) {
    $index = $i;
  }
#  $maxEndingHere = max($maxEndingHere + $arr[$i], 0);
  $maxEndingHere = max($maxEndingHere + $gasStation[$i] - $distances[$i], 0);
  $maxSoFar = max($maxSoFar, $maxEndingHere);
}

print $index;
print "\n";

## Testing solution

my @pDiff = ();
my $j =0;
for(my $i = $index; $i < scalar(@gasStation) ; $i++) {
  $pDiff[$j] = $gasStation[$i] - $distances[$i];
  $j++;
}
for(my $i = 0; $i < $index; $i++) {
  $pDiff[$j] = $gasStation[$i] - $distances[$i];
  $j++;
}

print join " ",@pDiff;
print "\n";

my $start = 0;
for(my $i =0 ; $i< scalar(@pDiff); $i++) {
  $start += $pDiff[$i];
  print "Adding " . $pDiff[$i] . " to make " . $start . "\n"; 
}
