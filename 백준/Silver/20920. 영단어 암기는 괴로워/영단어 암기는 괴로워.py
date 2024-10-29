import sys
input = sys.stdin.readline

n, m = map(int, input().split())
word_dict = {}
for _ in range(n):
    w = input().strip()
    if len(w) < m:
        continue
    else:
        if w in word_dict:
            word_dict[w] += 1
        else:
            word_dict[w] = 1
    
for i in range(max(word_dict.values()), 0, -1):
    d = [key for key, value in word_dict.items() if value == i]
    if d:
        a = sorted(d, key= lambda x: (-len(x), x))
        for k in a:
            print(f"{k}")

