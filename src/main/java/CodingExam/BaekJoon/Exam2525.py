A, B = map(int, input().split())
C = int(input())

total_minutes = A * 60 + B + C

H = (total_minutes // 60) % 24
M = total_minutes % 60

print(H, M)