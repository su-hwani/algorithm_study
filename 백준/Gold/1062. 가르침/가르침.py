N, M = map(int, input().split())

preWord = set(["a", "n", "t", "i", "c"])

fullWord = []
fullAlpha = set()


for _ in range(N):
    w = input()

    s = set()
    for char in w:
        if char not in preWord:
            s.add(char)
            fullAlpha.add(char)

    fullWord.append(s)

if M < 5:
    print(0)
else:
    from itertools import combinations

    combis = list(combinations(fullAlpha, min(M - 5, len(fullAlpha))))


    result = 0

    for combi in combis:
        combi = set(combi)
        combi = combi.union(preWord)

        res = 0
        for fw in fullWord:
            if fw.issubset(combi):
                res += 1

        result = max(res, result)
    print(result)
