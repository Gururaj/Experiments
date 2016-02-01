#!/usr/bin/perl 

use Data::Dumper;

$hash = {};

while(<>) {
	chomp;
	@d = split /,/;
	$date = $d[0];
	$hour = $d[1];
	$ch = $d[2];
	$imp = $d[3];
	$clk = $d[4];
	
	($year,$month,$day) = split /-/,$date;
	
	if($hour < 16) {
		# this belongs to older data. 
		$day = $day - 1;
		
	}
	$label = $month . '-' . $day . '[4PM-4PM]-' . $ch;		
	
	if (exists $hash->{$label}) 
	{
		$olddata = $hash->{$label};
		$newimp = $olddata->{'imp'};
		$newimp += $imp;
		$newclk = $olddata->{'clk'};
		$newclk += $clk;
		
		
		$count = $olddata->{'count'};
		$count+=1;
		$data = {
			'imp' => $newimp,
			'clk' => $newclk,
			'count' => $count
		};
		$hash->{$label} = $data;
	}
	else 
	{
		$data = {
			'imp' => $imp,
			'clk' => $clk,
			'count' => 1
		};
		$hash->{$label} = $data;
	}
}

# print Dumper($hash);

for $l (keys %{$hash})
{
	$val = $hash->{$l};
	$c = $val->{'count'};
	next if($c != 24);
	$i = $val->{'imp'};
	$c = $val->{'clk'};
	print $l . ",".$i . "," . $c . "," . $c * 100/$i . "\n";
}
