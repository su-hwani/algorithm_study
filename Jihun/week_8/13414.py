import sys
input = sys.stdin.readline

K, L = map(int, input().split())

dic = dict()

order = 1
for i in range(L):
    number = input()
    if number in dic:
        dic[number] = order
    else:
        dic[number] = order
    order += 1

result = sorted(dic.items(), key=lambda x : x[1])

if K <= len(dic):
    for i in range(K):
        print(result[i][0], end="")
else:
    for i in range(len(dic)):
        print(result[i][0], end="")
    