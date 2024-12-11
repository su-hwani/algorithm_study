import sys
input = sys.stdin.readline

words = input().strip()

break_point = 1
result = 0
stack = []
temp = 1

for i in range(len(words)):
    char = words[i]
    
    if char == "(":
        stack.append(char)
        temp *= 2
    elif char == "[":
        stack.append(char)
        temp *= 3
    elif char == ")":
        if not stack or stack[-1] != "(":
            result = 0
            break_point = 0
            break
        if words[i - 1] == "(":  # 바로 이전이 열린 괄호인 경우
            result += temp
        stack.pop()
        temp //= 2
    elif char == "]":
        if not stack or stack[-1] != "[":
            result = 0
            break_point = 0
            break
        if words[i - 1] == "[":  # 바로 이전이 열린 괄호인 경우
            result += temp
        stack.pop()
        temp //= 3

if break_point and not stack:
    print(result)
else:
    print(0)