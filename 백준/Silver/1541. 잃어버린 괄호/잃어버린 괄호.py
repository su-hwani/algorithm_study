line = list(input().split('-'))

# line 갯수가 1이면 전부 + 
# line 갯수가 2이상이면 - 가 있다. 
if len(line) == 1:
    num_list = line[0].split('+')
    result = 0 
    for i in num_list:
        result += int(i)
    print(result)     
else: 
    if line[0] == '':
        result = 0
        for i in range(1,2):
            num = line[1]
            num = num.split('+')
            result_plus = 0
            for k in num: 
                result_plus += int(k) 
            result -= result_plus
        
        for i in range(2,len(line)): 
            num = line[i]
            num = num.split('+')
            result_plus = 0
            for k in num:
                result_plus += int(k) 
            result -= result_plus
        print(result)
    else:
        result = 0
        for i in range(0, 1):
            num = line[0]
            num = num.split('+')
            result_plus = 0
            for k in num: 
                result_plus += int(k) 
            result += result_plus
        
        for i in range(1, len(line)):
            num = line[i]
            num = num.split('+')
            result_plus = 0
            for k in num:
                result_plus += int(k)
            result -= result_plus
        print(result)