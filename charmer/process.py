from gsm import utils

__author__ = 'gseethar'

from gsm.csv.CsvReader import CsvReader

csv = CsvReader('/Users/gururaj/Dropbox/SampleDataSet/channeldataCost.csv')

d = csv.getdictlist(isHeader=False)

print utils.prettyprint(d)