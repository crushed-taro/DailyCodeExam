hour, minute = map(int, input().split())

total_minutes = hour * 60 + minute - 45

if total_minutes < 0:
    total_minutes += 24 * 60

hour = total_minutes // 60
minute = total_minutes % 60

print(hour, minute)