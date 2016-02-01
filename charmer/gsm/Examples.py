from collections import deque

def fibonnaci(num):
    a, b = 0, 1
    while b < num:
        print b
        a, b = b, a+b

"""
Asks for prompt and returns the message
"""
def prompt(mesg):
    x = raw_input(mesg)
    return x


def arguments(kind, *args, **keywords):
    print "Default one is " + kind
    for arg in args:
        print arg

    keys = sorted(keywords.keys())

    for key in keys:
        print key + ":" + keywords[key]


def combinations(lista, listb):
    # check if x and y are list ..
    return [ (x, y) for x in lista for y in listb if x != y]


