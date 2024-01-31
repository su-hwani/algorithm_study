string = input()

stack = []

for letter in string:
    stack.append(letter)
    length = len(stack)
    if letter == "P" and length >= 4:
        if stack[length - 2] == "A" and stack[length - 3] == "P" and stack[length - 4] == "P":
            for i in range(4):
                stack.pop()
            stack.append(letter)
print("PPAP" if "".join(stack) == "P" else "NP")