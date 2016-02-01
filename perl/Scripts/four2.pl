#!/usr/bin/perl 

use Data::Dumper;

while(<>) {
	chomp;
	@d = split /,/;
	$date = $d[0];	
	
	$ch = $d[1];
	$imp = $d[2];
	$clk = $d[3];
	$rev = $d[4];
	if( $ch == 2 )
	{
		$ch = 'Desktop';
	}
	
	if( $ch == 2000 )
	{
		$ch = 'Tablet';
	}
	
	if( $ch == 3000 )
	{
		$ch = 'Mobile';
	}
	
	print $date . "," . $ch . ",".$imp . "," . $clk . "," . $clk * 100/$imp . ",", $rev . "\n";
	#print $date .  ",".$imp . "," . $clk . "," . $clk * 100/$imp . ",", $rev . "\n";
	
}
