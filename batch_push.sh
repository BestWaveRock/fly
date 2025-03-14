#!/bin/bash

# Docker Hub 用户名
DOCKER_USER="erin099"

# 遍历所有 biscuits 开头的镜像
docker images --format "{{.Repository}}:{{.Tag}}" | grep "^biscuits-" | while read -r image; do
    # 提取镜像名（去除 TAG）
    repo_name=$(echo "$image" | cut -d':' -f1)
    tag=$(echo "$image" | cut -d':' -f2)
    
    # 新镜像名（符合 Docker Hub 规范）
    new_image="${DOCKER_USER}/${repo_name}:${tag}"
    
    # 打标签
    echo "Tagging: $image → $new_image"
    docker tag "$image" "$new_image"
    
    # 生成 push 命令
    echo "docker push $new_image" >> push_commands.sh
done

# 赋予执行权限
chmod +x push_commands.sh

echo "操作完成！请运行 ./push_commands.sh 推送所有镜像"

