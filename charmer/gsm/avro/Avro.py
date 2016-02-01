__author__ = 'gseethar'

from gsm.avro.Avro.datafile import DataFileReader,DataFileWriter
from gsm.avro.Avro.io import DatumReader, DatumWriter

def test():
    print "Avro Utils"


def parseSchema(schemafile):
    return avro.schema.parse(schemafile)

"""

"""
def openForWrite(avrofile, outschema):
    writer = DataFileWriter(open(avrofile, "w"), DatumWriter(), outschema)
    return writer

def write(writer, record):
    writer.append(record)

def close(avro_object):
    avro_object.close()

def openForReader(avrofile):
    reader = DataFileReader(open(avrofile, "r"), DatumReader)
    return reader