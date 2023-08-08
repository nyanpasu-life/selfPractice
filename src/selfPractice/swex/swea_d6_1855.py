INF = 999999999

def getDist(now, dest, edgeInfo, v, cumul):
    if(now ==dest):
        return cumul

    for next in edgeInfo[now]:
        if v[next]:continue
        v[next] = True
        a = getDist(next, dest, edgeInfo, v, cumul+1)
        if(a is not None):
            return a
        v[next] = False
        
    return None

import sys
sys.stdin = open("res/input_d6_1855.txt")

T = int(input())

for tc in range(1, T+1):
    N = int(input())
    
    parentInfo = {}
    childInfo ={}
    edgeInfo = {}
    for i in range(1, N+1):
        parentInfo[i] = []
        childInfo[i] = []
    
    line = input()
    line = list(map(lambda x: int(x), line.split(" ")))

    for child in range(2, N+1):
        parent = line[child -2]
        parentInfo[child].append(parent)
        childInfo[parent].append(child)
    
    for i in range(1, N+1):
        edgeInfo[i] = parentInfo[i] + childInfo[i]
    
    queue1 = []
    before = 1
    for k in childInfo[1]:
        queue1.append(k)

    dist = 0
    while(len(queue1) >0):
        after = queue1[0]
        del queue1[0]

        for k in childInfo[after]:
            queue1.append(k)
        
        stack = []
        stack.append(before)
        target = before

        v = [False for i in range(N+1)]
        v[before] = True
        dist += getDist(before, after, edgeInfo, v, 0)
        print(dist)
    
    print(dist)