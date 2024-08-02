N = int(input())

max_pibo = 1
second_max_pibo = 0
pibo =[0, 1] 
real_result = []
for _ in range(N):
    num = int(input())
    result = []
    
    while max_pibo < num:
        new_max_pibo = max_pibo + second_max_pibo
        pibo.append(new_max_pibo)
        second_max_pibo = max_pibo
        max_pibo = new_max_pibo
        
    for i in range(len(pibo)-1, -1, -1):
        if pibo[i] <= num:
            result.append(pibo[i])
            num -= pibo[i]
        if num == 0:
            break 
    
    real_result.append(result)

for i in range(len(real_result)):
    for k in range(len(real_result[i])-1,-1,-1):
        print(real_result[i][k], end=" ")
    print('')