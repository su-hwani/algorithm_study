import sys
input = sys.stdin.readline

n = int(input())

def fun1(words):
    from itertools import permutations 
    p = permutations(words, 2)
    for i in p:
        ans = fun2(i[0]+i[1], 0, len(i[0]+i[1])-1)
        if ans:
            return i[0]+i[1]
    return None
    
def fun2(word, start, last):
    if start >= last:
        return True
    elif word[start] == word[last]:
        return fun2(word, start+1, last-1)
    else:
        return False
    
    
for _ in range(n):
    m = int(input())
    words = []
    for __ in range(m):
        word = input()
        words.append(word[:-1])
    ans = fun1(words)
    if ans:
        print(ans)
    else:
        print(0)