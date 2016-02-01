__author__ = 'gseethar'

import pprint


def prettyprint(obj):
    pp = pprint.PrettyPrinter(indent=4)
    pp.pprint(obj)