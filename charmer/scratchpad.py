from collections import deque
from gsm.Examples import combinations

def even(x): return x % 2 == 0

print filter(even, range(1,1000))

def cube(x): return x*x*x

print map(cube, range(1,10))

def add(x, y): return x + y

seq = range(8)

print map(add, seq, seq)

print reduce(add, range(1, 11))

print reduce(add, range(1, 11), 100)

print sum(range(1,11))

queue = deque(['a','b'])
print queue
queue.append('c')
print queue
print queue.popleft()
print queue

seq = range(3)
print combinations(seq, seq)
