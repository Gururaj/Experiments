
$headers = 0;
@head = ();
while($line = <>)
{
	chomp $line;
	if($headers == 0)
	{
		@k = split /,/,$line;
		push @head, @k;
		$headers = 1;
	}
	else 
	{
		@k = split /,/,$line;
		$len = scalar(@k);
		
		print "{";
		$out = "";
		for( $i = 0; $i < $len; $i++)
		{	
			$val = $k[$i];			
			$val = 0 if(!defined $k[$i] || $k[$i] == '');
			$out .= qq("$head[$i]" : $val,);						
		}
		chop($out);
		print $out;
		print "}\n";
	}
}