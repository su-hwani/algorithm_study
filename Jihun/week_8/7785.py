n = int(input())
enter = set()

for i in range(n):
    name, state = input().split()
    if state == "enter":
        enter.add(name)
    else:
        enter.remove(name)

now = sorted(enter, reverse=True)
for name in now:
    print(name)