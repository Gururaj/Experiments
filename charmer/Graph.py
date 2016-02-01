#!/usr/bin/python

from abc import ABCMeta, abstractmethod

class Graph:
    __metaclass__ = ABCMeta

    numVertices = 0
    numEdges = 0

    adjList = dict()

    @abstractmethod
    def distance2(self): pass

    def addVertice(self, v):
        self.numVertices += 1
        self.adjList[v] = []

    def addEdge(self, start, end):
        if not self.adjList.has_key(start):
            raise ValueError("Vertice %s does not exist"%(start))
        if not self.adjList.has_key(end):
            raise ValueError("Vertice %s does not exist"%(end))

        self.adjList[start].append(end)
        self.numEdges += 1

    def __str__(self):
        string = ""
        string += "Num of Vertices %d\n"%(self.numVertices)
        string += "Num of Edges %d\n"%(self.numEdges)
        string += "AdJList = %s"%(self.adjList)
        return string


    def __repr__(self):
        return self.__str__()
