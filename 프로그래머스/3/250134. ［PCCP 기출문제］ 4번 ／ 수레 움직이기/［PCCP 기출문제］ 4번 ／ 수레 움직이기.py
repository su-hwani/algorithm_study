from collections import deque

def solution(maze):
    red_start = red_end = blue_start = blue_end = None
    x_length = len(maze)
    y_length = len(maze[0])

    for i in range(x_length):
        for k in range(y_length):
            if maze[i][k] == 1:
                red_start = (i, k)
            elif maze[i][k] == 2:
                blue_start = (i, k)
            elif maze[i][k] == 3:
                red_end = (i, k)
            elif maze[i][k] == 4:
                blue_end = (i, k)

    count, answer = 0, int(1e9)
    red_visited = [[False] * y_length for _ in range(x_length)]
    blue_visited = [[False] * y_length for _ in range(x_length)]

    q = deque([(red_start, blue_start, count, red_visited, blue_visited)])

    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    while q:
        R, B, C, RV, BV = q.popleft()
        # print(f"R: {R}, B: {B}, RV: {RV}, BV: {BV}, C: {C}")
        RV[R[0]][R[1]] = True
        BV[B[0]][B[1]] = True

        if R == red_end and B == blue_end:
            answer = min(C, answer)
            break

        if C > answer:
            continue

        if R == red_end:
            # Red 고정, Blue만 이동
            for nb in range(4):
                nbx, nby = B[0] + dx[nb], B[1] + dy[nb]
                if 0 <= nbx < x_length and 0 <= nby < y_length and maze[nbx][nby] != 5:
                    if (nbx, nby) != R and not BV[nbx][nby]:
                        q.append(((R[0], R[1]), (nbx, nby), C + 1, copy_visited(RV, x_length, y_length), copy_visited(BV, x_length, y_length)))
        else:
            for nr in range(4):
                nrx, nry = R[0] + dx[nr], R[1] + dy[nr]
                if 0 <= nrx < x_length and 0 <= nry < y_length and maze[nrx][nry] != 5:
                    if B == blue_end:
                        # Blue 고정, Red만 이동
                        if (nrx, nry) != B and not RV[nrx][nry]:
                            q.append(((nrx, nry), (B[0], B[1]), C + 1, copy_visited(RV, x_length, y_length), copy_visited(BV, x_length, y_length)))
                    else:
                        # Red/Blue 동시 이동
                        for nb in range(4):
                            nbx, nby = B[0] + dx[nb], B[1] + dy[nb]
                            if 0 <= nbx < x_length and 0 <= nby < y_length and maze[nbx][nby] != 5:
                                if (nrx, nry) == (nbx, nby):
                                    continue  # 같은 칸 동시 진입 금지
                                if (R[0], R[1]) == (nbx, nby) and (nrx, nry) == (B[0], B[1]):
                                    continue  # 서로 자리 교환 금지
                                if not RV[nrx][nry] and not BV[nbx][nby]:
                                    q.append(((nrx, nry), (nbx, nby), C + 1, copy_visited(RV, x_length, y_length), copy_visited(BV, x_length, y_length)))

    return answer if answer != int(1e9) else 0

def copy_visited(visited, x_length, y_length):
    new = [[False] * y_length for _ in range(x_length)]
    for i in range(len(visited)):
        for k in range(len(visited[i])):
            new[i][k] = visited[i][k]
    return new 