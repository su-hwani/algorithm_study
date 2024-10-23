import sys
input = sys.stdin.readline



def hanoi(n, start, between, end):
    global count
    if n == 0:
        return
    hanoi(n-1, start, end, between)
    print(f"{start} {end}")
    hanoi(n-1, between, start, end)
    
n = int(input())
print(2**n-1)
if n <= 20:
    hanoi(n, 1, 2, 3)
