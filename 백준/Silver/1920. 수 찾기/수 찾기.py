import sys
input = sys.stdin.readline

N = int(input())
nums = list(map(int, input().split()))

dicts = {x:0 for x in nums}



M = int(input())
answers = list(map(int, input().split()))



for i in answers:
    if i in dicts:
        print(1)
    else:
        print(0)

