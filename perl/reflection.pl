
sub reflect { print "I am number 1\n";}
sub reflect2 { print "The second\n";}
$var = &{$ARGV[0]};
{$var}();

