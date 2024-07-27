import sys

K, L = map(int, sys.stdin.readline().split())

studentDict = {}

for i in range(L):
    studentDict[sys.stdin.readline().rstrip()] = i


sortedDict = sorted(studentDict.items(), key=lambda x: x[1])

if (K > len(sortedDict)):
    K = len(sortedDict)

for i in range(K):
    print(sortedDict[i][0])