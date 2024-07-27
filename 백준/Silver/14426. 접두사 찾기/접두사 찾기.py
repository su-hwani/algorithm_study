N, M = map(int, input().split())

SList = []
MList = []

for _ in range(N):
    string = input()
    SList.append(string)

for _ in range(M):
    string = input()
    MList.append(string)
    
SList.sort()
MList.sort()

SIndex = 0
MIndex = 0
result = 0


while len(SList) > SIndex and len(MList) > MIndex:
    if SList[SIndex][:len(MList[MIndex])] == MList[MIndex]:
        MIndex += 1
        result += 1
    elif MList[MIndex] > SList[SIndex]:
        SIndex += 1
    else:
        MIndex += 1
    
print(result)