import sys
input = sys.stdin.readline

a_top, a_bot = map(int, input().split())
b_top, b_bot = map(int, input().split())

n_top = a_top * b_bot + a_bot * b_top
n_bot = a_bot * b_bot

def gcd(a, b):
    while b:
        a, b = b, a % b 
    return a

while True:
    q = gcd(max(n_top, n_bot), min(n_top, n_bot))
    n_top = n_top // q
    n_bot = n_bot // q
    
    if q == 1:
        break

print(f"{n_top} {n_bot}")