n = int(input())

# n = (n - 1) + (n - 3)

arr = [0 for _ in range(n + 2)]
arr[0] = 1
arr[1] = 1
arr[2] = 2

for i in range(3, n + 1):
    arr[i] = (arr[i - 1] + arr[i - 3]) % 1000000009
print(arr[n - 1])