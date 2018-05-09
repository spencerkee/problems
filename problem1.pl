use strict;
use warnings;


my %word_counts;

open(FILE, "<article.txt") or die "Could not open file: $!";
while (<FILE>) {
    $word_counts{lc $1} += 1 while /(\w+)/g;
}
close FILE;

my @keys = sort { $word_counts{$b} <=> $word_counts{$a} } keys(%word_counts);

my $i = 0;
while($i < scalar @keys) {
    print "Count: ".$word_counts{$keys[$i]}." Word: ".$keys[$i]."\n";
    $i++;
}
