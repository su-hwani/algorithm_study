

fstStr = input() 
secStr = input() 

res = fstStr.split(secStr)
if len(res) >= 2: 
    print(1) 
else:
    print(0)