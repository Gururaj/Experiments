import os

"""
Module for all file system helpers
"""

def isFileExists(file):
    if file and os.path.isfile(file):
        return True
    else:
        return False

# Create file with the path
def touchFile(path, file):
    if file:
        os.mkdir(path)

