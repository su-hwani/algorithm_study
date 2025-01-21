import sys
input = sys.stdin.readline
            

n, m = map(int, input().split())
array = []

def back():
    if len(array) == m:
        print(' '.join(map(str, array)))
        return 
    
    for i in range(1, n+1):
        # if len(array) > 0 and array[-1] > i:
        #     continue
        # if i not in array:
        #     array.append(i)
        #     back()
        #     array.pop()
        if len(array) > 0 and array[-1] > i:
            continue
        array.append(i)
        back()
        array.pop()
            
back()