import sys
input = sys.stdin.readline
n = int(input())
number = 666

# 666
# 1666
# 2666
# 3666
# 4666
# 5666
# 6660 ~ 6669 10개
# 7666
# 8666
# 9666 19개
# 10666
# 11666
# 12666
# 13666
# 14666
# 15666
# 16660 ~ 1669 10개
# 17666
# 18666
# 19666 19개
# 60666
# 61666
# 62666
# 63666
# 64666
# 65666
# 66600 ~ 66699 100개 

while n != 1:
    number += 1
    if  "666" in str(number):
        n -= 1
    
print(number)