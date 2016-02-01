__author__ = 'gseethar'


class Csv:

    _fileName = None
    # keep variable name as filename

    def __init__(self, fileName):
        self._fileName = fileName;

    def verifyFile(self):
        if self._fileName == None:
            #raise an exception
            print "File is none"
