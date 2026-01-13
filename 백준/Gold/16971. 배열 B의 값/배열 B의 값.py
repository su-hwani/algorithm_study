n, m = map(int, input().split())
map_data = []
for _ in range(n):
 
    map_data.append(list(map(int, input().split())))
 
# 가장 작은 행 찾기
min_row_sum = int(1e9)
first_row, last_row = 0, 0
total_r = 0
for i in range(n):
    row_sum = map_data[i][0] + map_data[i][m-1]
    for j in range(1, m-1):
        row_sum += 2 * map_data[i][j]
    total_r += (row_sum * 2)
    if i == 0:
        first_row = row_sum
    elif i == n-1:
        last_row = row_sum
    else:
        if min_row_sum > row_sum:
            min_row_sum = row_sum
# 안 바꾸는게 최대
if min_row_sum > max(first_row, last_row):
    total_r -= (first_row + last_row)
# 테두리 2행 중 큰 거와 바꾸기
else:
    total_r -= (min_row_sum + min(first_row, last_row))
 
# 가장 작은 열 찾기
min_col_sum = int(1e9)
first_col, last_col = 0, 0
total_c = 0
for j in range(m):
    col_sum = (map_data[0][j]+map_data[n-1][j])
    for i in range(1, n-1):
        col_sum += 2 * map_data[i][j]
    total_c += (col_sum * 2)
    if j == 0:
        first_col = col_sum
    elif j == m-1:
        last_col = col_sum
    else:
        if min_col_sum > col_sum:
            min_col_sum = col_sum
# 안 바꾸는게 최대
if min_col_sum > max(first_col, last_col):
    total_c -= (first_col + last_col)
# 테두리 2열 중 큰 거와 바꾸기
else:
    total_c -= (min_col_sum + min(first_col, last_col))
print(max(total_r, total_c))