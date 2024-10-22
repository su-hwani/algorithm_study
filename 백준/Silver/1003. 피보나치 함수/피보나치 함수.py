import sys
input = sys.stdin.readline

table = [[1,0], [0,1]]

def fibo(n):
    if n <= len(table)-1:
        return table[n]
    else:
        for i in range(n-len(table)+1):
            table.append([
                table[-1][0] + table[-2][0],
                table[-1][1] + table[-2][1],
            ])
        return table[-1]

n = int(input())
for _ in range(n):
    number = int(input())
    answer = fibo(number)
    print(answer[0], answer[1])