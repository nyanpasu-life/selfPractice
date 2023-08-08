import sys
sys.stdin = open("res/input_swea_d6_1263.txt")
T = int(input())

INF = 999999999

for tc in range(1, T+1):
    line = input()
    line = line.split(" ")
    N = int(line[0])
    arr = [[0 for i in range(N)] for j in range(N)]

    for i in range(0, N):
        for j in range(0, N):
            arr[i][j] = int(line[1+i*N+j])
            if arr[i][j] ==0 and i is not j:
                arr[i][j] = INF
    
    for k in range(0, N):
        for i in range(0, N):
            if i is k : continue
            for j in range(0, N):
                if (j is k) or (i is j): continue
                candidate = arr[i][k] + arr[k][j]
                if arr[i][j] > candidate: arr[i][j] = candidate

    min_cc = INF

    for i in range(N):
        cc = 0
        for j in range(N):
            cc+= arr[i][j]
        min_cc = min(min_cc, cc)
    
    print("#{} {}".format(tc, min_cc))
