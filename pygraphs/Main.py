#!/usr/bin/python

from GraphAdjList import GraphAdjList

graphAdjList = GraphAdjList()
graphAdjList.addVertice(1)
graphAdjList.addVertice(2)
graphAdjList.addVertice(3)
graphAdjList.addVertice(4)

graphAdjList.addEdge(1,2)
graphAdjList.addEdge(2,1)
graphAdjList.addEdge(3,1)
graphAdjList.addEdge(4,1)
graphAdjList.addEdge(2,3)
graphAdjList.addEdge(2,4)
graphAdjList.addEdge(3,4)
graphAdjList.addEdge(4,2)

print "Graph is %s"%(graphAdjList)
