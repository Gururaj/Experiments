from gsm.csv import Csv

__author__ = 'gseethar'

import csv

class CsvReader(Csv.Csv):

    def getlist(self):
        self.verifyFile()
        list = []
        with open(self._fileName, 'rb') as f:
            reader = csv.reader(f)
            for row in reader:
                list.append(row)
        return list

    """
    Reads a file and converts to list of hash value.
    If header exits then first row is used as header else, just index

    """
    def getdictlist(self, isHeader = True):
        dictlist = []
        rownum = 0
        list = self.getlist()
        for row in list:
            dictvalue = dict()
            if isHeader is True and rownum == 0:
                header = row
            else:
                colnum = 0
                for col in row:
                    if isHeader is True:
                        dictvalue[header[colnum]] = col
                    else:
                        dictvalue[colnum] = col
                    colnum += 1
            rownum += 1
            dictlist.append(dictvalue)
        return dictlist

