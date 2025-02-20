import sys
input = sys.stdin.readline

N, M = map(int, input().split())
nums = list(map(int, input().split()))
count = 0

start, end, sums = 0, 0, nums[0]

while end < N and start < N:
    # print(f"start: {start}, end: {end}, sums: {sums}")
    
    if sums > M:
        if start == end: 
            start += 1
            end += 1
            if start < N:  # ✅ 배열 범위를 초과하지 않도록 체크
                sums = nums[start]
            
        else:
            sums -= nums[start]
            start += 1
    else:
        if sums == M:
            count += 1
        end += 1
        if end < N:
            sums += nums[end]
    
print(count)