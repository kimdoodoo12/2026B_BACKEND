

commands = ["next", "prev", "next"]
video_len = "34:33"
pos = "13:00"
skip = "00:10"
op_start = "00:55"
op_end = "02:55"

# The first 'datetime' is the module, the second is the class
parsed_len = list(map(int, video_len.split(":")))
parsed_pos = list(map(int, pos.split(":")))
skip = list(map(int, skip.split(":")))
parsed_start = list(map(int, op_start.split(":")))
parsed_end = list(map(int, op_end.split(":")))

if (parsed_pos[0] >= parsed_start[0] and parsed_pos[0] <= parsed_end[0]):
    if (parsed_pos[1] >= parsed_start[1] and parsed_pos[1] <= parsed_end[1]):
        parsed_pos[0] = parsed_end[0]
        parsed_pos[1] = parsed_end[1]


for i in commands:
    if(i == "next"):
        temp = parsed_pos[1] + skip[1]
        if (temp >= 60):
            parsed_pos[1] += (temp-60)
            parsed_pos[0] += 1
        else:
            parsed_pos[1] = temp
        
    elif(i == "prev"):
        temp = parsed_pos[1] - skip[1]
        if (temp < 0):
            parsed_pos[1] += (temp+60)
            parsed_pos[0] -= 1
        else:
            parsed_pos[1] = temp




print(parsed_pos)