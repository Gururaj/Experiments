from gsm.csv import Csv

__author__ = 'gseethar'

# library
import csv

class CsvWriter(Csv.Csv):

    def write(self):
        with open(self._fileName, 'wb') as f:
            writer = csv.writer( f, )