N = int(input())

num_list = [ x for x in range(1, N+1) ]

while len(num_list) >= 2:
    num_0 = num_list.pop(0)
    print(num_0, end=" ")
    num_1 = num_list.pop(0)
    num_list.append(num_1)
    
print(num_list.pop(0))