N, C = map(int, input().split())
numbers = list(map(int, input().split()))

dic = dict()

for number in numbers:
    if number not in dic:
        dic[number] = 1
    else:
        dic[number] += 1

result = sorted(dic.items(), key=lambda x : x[1], reverse=True)

for item in result:
    print((str(item[0]) + " ") * item[1], end='')
print()