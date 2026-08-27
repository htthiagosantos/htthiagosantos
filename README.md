<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Perfil Cyberpunk · Java Backend</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        body {
            background: #0b0d15;
            font-family: 'Inter', 'Segoe UI', system-ui, -apple-system, sans-serif;
            color: #e0e6f0;
            line-height: 1.6;
            padding: 2rem 1.5rem;
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        .readme-container {
            max-width: 1000px;
            width: 100%;
            background: rgba(13, 17, 27, 0.85);
            backdrop-filter: blur(4px);
            border-radius: 2.5rem;
            padding: 2.5rem 2rem;
            box-shadow: 0 20px 40px -12px rgba(0, 0, 0, 0.9), 0 0 0 1px rgba(0, 255, 255, 0.15);
            border: 1px solid rgba(0, 255, 255, 0.08);
            transition: all 0.2s;
        }
        h1, h2, h3 {
            font-weight: 500;
            letter-spacing: 0.02em;
        }
        .glow-text {
            text-shadow: 0 0 8px rgba(0, 255, 255, 0.3);
        }
        .cyber-border {
            border-bottom: 2px solid rgba(0, 255, 255, 0.2);
            padding-bottom: 0.5rem;
            margin-bottom: 1.5rem;
            display: flex;
            align-items: center;
            gap: 0.75rem;
        }
        .cyber-border span {
            color: #00f0ff;
            font-weight: 600;
            text-transform: uppercase;
            font-size: 0.85rem;
            letter-spacing: 0.2em;
        }
        .card-grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
            gap: 1.5rem;
            margin: 1.5rem 0;
        }
        .card {
            background: rgba(18, 24, 38, 0.7);
            backdrop-filter: blur(2px);
            border-radius: 1.8rem;
            padding: 1.5rem 1.2rem;
            border: 1px solid rgba(0, 255, 255, 0.08);
            box-shadow: 0 8px 20px -8px rgba(0, 0, 0, 0.6);
            transition: 0.25s ease;
        }
        .card:hover {
            border-color: #00f0ff;
            box-shadow: 0 0 25px -6px rgba(0, 240, 255, 0.2);
            transform: translateY(-3px);
        }
        .card-title {
            color: #b0c7e7;
            font-size: 0.9rem;
            text-transform: uppercase;
            letter-spacing: 0.1em;
            margin-bottom: 0.7rem;
            display: flex;
            align-items: center;
            gap: 8px;
        }
        .badge-list {
            display: flex;
            flex-wrap: wrap;
            gap: 0.6rem;
            margin: 0.8rem 0;
        }
        .badge-list img {
            height: 28px;
            border-radius: 20px;
            filter: drop-shadow(0 0 6px rgba(0, 200, 255, 0.2));
        }
        .icon-stack {
            display: flex;
            flex-wrap: wrap;
            gap: 0.8rem;
            align-items: center;
        }
        .icon-stack img {
            height: 38px;
            width: auto;
            filter: drop-shadow(0 0 6px rgba(0, 200, 255, 0.15));
            transition: 0.2s;
        }
        .icon-stack img:hover {
            transform: scale(1.1);
            filter: drop-shadow(0 0 12px #00f0ff);
        }
        .terminal-box {
            background: #0a0e1a;
            border-radius: 1.2rem;
            padding: 1.2rem 1.5rem;
            font-family: 'Fira Code', 'JetBrains Mono', monospace;
            font-size: 0.9rem;
            border-left: 4px solid #00f0ff;
            margin: 1.2rem 0;
            box-shadow: inset 0 0 30px rgba(0, 240, 255, 0.03);
            color: #b4e6ff;
        }
        .terminal-box .prompt {
            color: #00f0ff;
            font-weight: 500;
        }
        .terminal-box .cursor {
            display: inline-block;
            width: 10px;
            height: 1.2rem;
            background: #00f0ff;
            vertical-align: text-bottom;
            animation: blink 1s step-end infinite;
        }
        @keyframes blink {
            0%, 100% { opacity: 1; }
            50% { opacity: 0; }
        }
        .boot-line {
            font-family: 'Fira Code', monospace;
            font-size: 0.85rem;
            color: #6c8cff;
            letter-spacing: 0.1em;
            opacity: 0.7;
            border-bottom: 1px dashed rgba(0, 255, 255, 0.1);
            padding-bottom: 0.5rem;
            margin-bottom: 1.2rem;
        }
        .boot-line .highlight {
            color: #00f0ff;
            font-weight: 600;
        }
        .divider {
            width: 100%;
            height: 1px;
            background: linear-gradient(90deg, transparent, #00f0ff80, transparent);
            margin: 2rem 0;
        }
        .footer-cyber {
            margin-top: 2rem;
            text-align: center;
            font-size: 0.8rem;
            color: #6a7b9c;
            border-top: 1px solid rgba(0, 255, 255, 0.08);
            padding-top: 1.8rem;
            letter-spacing: 0.05em;
        }
        .footer-cyber a {
            color: #00f0ff;
            text-decoration: none;
            margin: 0 10px;
        }
        .footer-cyber a:hover {
            text-shadow: 0 0 10px #00f0ff;
        }
        @media (max-width: 600px) {
            .readme-container { padding: 1.5rem 1rem; }
            .card-grid { grid-template-columns: 1fr; }
        }
        .typing-demo {
            display: inline-block;
            overflow: hidden;
            white-space: nowrap;
            border-right: 3px solid #00f0ff;
            width: 0;
            animation: typing 3.5s steps(30) 1s forwards, blink-caret 0.75s step-end infinite;
            font-weight: 500;
            font-size: 1.4rem;
            color: #d0e4ff;
        }
        @keyframes typing {
            from { width: 0; }
            to { width: 100%; }
        }
        @keyframes blink-caret {
            0%, 100% { border-color: #00f0ff; }
            50% { border-color: transparent; }
        }
        .typing-wrapper {
            display: inline-block;
            max-width: 100%;
        }
        .stats-row {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            gap: 1.2rem;
            margin: 1.5rem 0;
        }
        .stats-row img {
            max-width: 100%;
            height: auto;
            border-radius: 16px;
            box-shadow: 0 0 20px -8px #000000aa;
            border: 1px solid rgba(0, 255, 255, 0.05);
        }
        .social-links {
            display: flex;
            justify-content: center;
            gap: 1.8rem;
            margin: 0.8rem 0;
        }
        .social-links a {
            color: #b0c7e7;
            font-size: 1.8rem;
            transition: 0.2s;
            text-decoration: none;
        }
        .social-links a:hover {
            color: #00f0ff;
            transform: scale(1.1);
        }
        .snake-container {
            background: #0a0e1a;
            border-radius: 2rem;
            padding: 0.5rem;
            margin: 1.5rem 0;
            border: 1px solid rgba(0, 255, 255, 0.05);
        }
        .java-highlight {
            color: #00f0ff;
            font-weight: 600;
        }
        .backend-tag {
            background: #00f0ff15;
            border: 1px solid #00f0ff30;
            border-radius: 40px;
            padding: 0.2rem 1rem;
            font-size: 0.75rem;
            color: #9ac8ff;
        }
    </style>
</head>
<body>
<div class="readme-container">

    <!-- BOOT -->
    <div class="boot-line">
        <span class="highlight">◆</span> SISTEMA INICIALIZADO [v.3.0.1] <span style="color:#6c8cff;">•</span> <span style="color:#4a6a9a;">JARVIS_BACKEND</span> <span style="color:#6c8cff;">•</span> <span style="color:#00f0ff;">READY</span>
    </div>

    <!-- HEADER -->
    <div style="display: flex; flex-direction: column; gap: 0.2rem; margin-bottom: 1.8rem;">
        <h1 style="font-size: 2.8rem; font-weight: 600; background: linear-gradient(135deg, #b0e0ff, #00f0ff); -webkit-background-clip: text; -webkit-text-fill-color: transparent; background-clip: text; letter-spacing: -0.02em;">
            <span style="background: none; -webkit-text-fill-color: initial; color: #00f0ff;">⟨</span> 
            <span style="background: none; -webkit-text-fill-color: initial; color: #d0e4ff;">Kael</span>
            <span style="background: none; -webkit-text-fill-color: initial; color: #00f0ff;">_</span>
            <span style="background: none; -webkit-text-fill-color: initial; color: #b0c7e7;">Vex</span>
            <span style="background: none; -webkit-text-fill-color: initial; color: #00f0ff;">⟩</span>
        </h1>
        <div class="typing-wrapper">
            <span class="typing-demo" style="width: 0;">&gt; backend architect · java · distributed systems</span>
        </div>
        <div style="margin-top: 0.5rem; display: flex; gap: 0.8rem; flex-wrap: wrap;">
            <span class="backend-tag">⚡ JAVA · BACKEND</span>
            <span class="backend-tag">🛸 MICROSERVICES</span>
            <span class="backend-tag">🧠 JARVIS · CORE</span>
            <span class="backend-tag">☕ SPRING · ECOSYSTEM</span>
        </div>
    </div>

    <!-- SOBRE MIM -->
    <div class="cyber-border">
        <span>⏣ SOBRE · MIM</span>
    </div>
    <div style="display: flex; flex-wrap: wrap; gap: 1rem; align-items: center; margin-bottom: 0.8rem;">
        <div style="flex: 2; min-width: 200px;">
            <p style="color: #c6d9f0; font-size: 1rem; line-height: 1.7;">
                <span style="color: #00f0ff; font-weight: 500;">[sys.kael]</span> — <span class="java-highlight">engenheiro de software backend</span>, especialista em arquitetura de sistemas distribuídos e 
                microsserviços. Apaixonado por <span class="java-highlight">Java</span>, performance e escalabilidade. 
                Construo infraestruturas robustas e APIs resilientes com foco em clean code e boas práticas.
                <span style="color: #8099c9;">#Java #SpringBoot #Microservices #REST #Hibernate</span>
            </p>
        </div>
        <div style="flex: 1; min-width: 120px; background: #0a0e1a; border-radius: 2rem; padding: 0.5rem 1rem; border: 1px solid #00f0ff30; text-align: center;">
            <span style="color: #00f0ff;">⏣</span> <span style="color: #b0c7e7;">STATUS</span> <span style="color: #00f0ff; font-weight: 600;">ONLINE</span>
        </div>
    </div>

    <!-- TECH STACK - FOCADO EM JAVA E BACKEND -->
    <div class="cyber-border" style="margin-top: 2rem;">
        <span>◈ TECH · STACK</span>
    </div>
    <div class="icon-stack">
        <img src="https://img.shields.io/badge/-Java-007396?style=flat-square&logo=java&logoColor=white" alt="Java" />
        <img src="https://img.shields.io/badge/-Spring%20Boot-6DB33F?style=flat-square&logo=spring-boot&logoColor=white" alt="Spring Boot" />
        <img src="https://img.shields.io/badge/-Spring%20Cloud-6DB33F?style=flat-square&logo=spring&logoColor=white" alt="Spring Cloud" />
        <img src="https://img.shields.io/badge/-Hibernate-59666C?style=flat-square&logo=hibernate&logoColor=white" alt="Hibernate" />
        <img src="https://img.shields.io/badge/-JPA-007396?style=flat-square&logo=java&logoColor=white" alt="JPA" />
        <img src="https://img.shields.io/badge/-REST%20API-02569B?style=flat-square&logo=rest&logoColor=white" alt="REST" />
        <img src="https://img.shields.io/badge/-Microservices-FF6F00?style=flat-square&logo=spring&logoColor=white" alt="Microservices" />
        <img src="https://img.shields.io/badge/-Apache%20Kafka-231F20?style=flat-square&logo=apache-kafka&logoColor=white" alt="Kafka" />
        <img src="https://img.shields.io/badge/-PostgreSQL-4169E1?style=flat-square&logo=postgresql&logoColor=white" alt="PostgreSQL" />
        <img src="https://img.shields.io/badge/-MongoDB-47A248?style=flat-square&logo=mongodb&logoColor=white" alt="MongoDB" />
    </div>
    <div class="badge-list" style="margin-top: 0.6rem;">
        <img src="https://img.shields.io/badge/-JARVIS%20AI-00f0ff?style=for-the-badge&logo=openai&logoColor=white&labelColor=0a0e1a" alt="JARVIS AI" />
        <img src="https://img.shields.io/badge/-BACKEND%20ARCHITECT-6c8cff?style=for-the-badge&logo=verizon&logoColor=white&labelColor=0a0e1a" alt="Backend" />
        <img src="https://img.shields.io/badge/-SYSTEM%20DESIGN-ff00a0?style=for-the-badge&logo=cyberpunk&logoColor=white&labelColor=0a0e1a" alt="System Design" />
    </div>

    <!-- FERRAMENTAS -->
    <div class="cyber-border" style="margin-top: 2rem;">
        <span>⚙ FERRAMENTAS · UTILIZADAS</span>
    </div>
    <div class="badge-list">
        <img src="https://img.shields.io/badge/-IntelliJ%20IDEA-000000?style=flat-square&logo=intellij-idea&logoColor=white" alt="IntelliJ" />
        <img src="https://img.shields.io/badge/-VS%20Code-007ACC?style=flat-square&logo=visual-studio-code&logoColor=white" alt="VSCode" />
        <img src="https://img.shields.io/badge/-Eclipse-2C2255?style=flat-square&logo=eclipse&logoColor=white" alt="Eclipse" />
        <img src="https://img.shields.io/badge/-Postman-FF6C37?style=flat-square&logo=postman&logoColor=white" alt="Postman" />
        <img src="https://img.shields.io/badge/-Docker-2496ED?style=flat-square&logo=docker&logoColor=white" alt="Docker" />
        <img src="https://img.shields.io/badge/-Kubernetes-326CE5?style=flat-square&logo=kubernetes&logoColor=white" alt="K8s" />
        <img src="https://img.shields.io/badge/-GitHub%20Actions-2088FF?style=flat-square&logo=github-actions&logoColor=white" alt="GH Actions" />
        <img src="https://img.shields.io/badge/-Figma-F24E1E?style=flat-square&logo=figma&logoColor=white" alt="Figma" />
        <img src="https://img.shields.io/badge/-Windows-0078D6?style=flat-square&logo=windows&logoColor=white" alt="Windows" />
    </div>

    <!-- PROJETOS CARDS - FOCADOS EM BACKEND -->
    <div class="cyber-border" style="margin-top: 2rem;">
        <span>⎔ PROJETOS · DESTAQUE</span>
    </div>
    <div class="card-grid">
        <div class="card">
            <div class="card-title">⟡ API · GATEWAY</div>
            <p style="color: #b8cce5; font-size: 0.9rem;">Gateway resiliente com Spring Cloud Gateway, rate limiting e circuit breaker. <span style="color: #00f0ff;">#SpringCloud #Resilience4j</span></p>
        </div>
        <div class="card">
            <div class="card-title">⟡ ORCHESTRATOR</div>
            <p style="color: #b8cce5; font-size: 0.9rem;">Orquestrador de microsserviços com Saga pattern e Kafka. <span style="color: #00f0ff;">#Kafka #Saga #Microservices</span></p>
        </div>
        <div class="card">
            <div class="card-title">⟡ DATA · PIPELINE</div>
            <p style="color: #b8cce5; font-size: 0.9rem;">Pipeline de dados com Spring Batch, JPA e PostgreSQL. <span style="color: #00f0ff;">#SpringBatch #JPA #SQL</span></p>
        </div>
    </div>

    <!-- OBJETIVOS TERMINAL - FOCADOS EM BACKEND -->
    <div class="cyber-border" style="margin-top: 2rem;">
        <span>⌨ OBJETIVOS · ATUAIS</span>
    </div>
    <div class="terminal-box">
        <div><span class="prompt">$</span> <span style="color: #b0e0ff;">> sys.target --list --backend</span></div>
        <div><span class="prompt">>></span> <span style="color: #9ac8ff;">[1]</span> Implementar API Gateway com Spring Cloud e autenticação JWT</div>
        <div><span class="prompt">>></span> <span style="color: #9ac8ff;">[2]</span> Migrar monólito para arquitetura de microsserviços com Docker/K8s</div>
        <div><span class="prompt">>></span> <span style="color: #9ac8ff;">[3]</span> Construir sistema de cache distribuído com Redis e Spring Cache</div>
        <div><span class="prompt">>></span> <span style="color: #9ac8ff;">[4]</span> Implementar observabilidade com Micrometer, Prometheus e Grafana</div>
        <div><span class="prompt">$</span> <span style="color: #00f0ff;">▸</span> <span style="color: #b4e6ff;">status: em andamento</span> <span class="cursor" style="margin-left: 6px;"></span></div>
    </div>

    <!-- ESTATÍSTICAS -->
    <div class="cyber-border" style="margin-top: 2rem;">
        <span>📊 METRICS · GITHUB</span>
    </div>
    <div class="stats-row">
        <img src="https://github-readme-stats.vercel.app/api?username=kaelvex&show_icons=true&theme=radical&hide_border=true&bg_color=0a0e1a&title_color=00f0ff&icon_color=00f0ff&text_color=b0c7e7" alt="GitHub Stats" width="48%" />
        <img src="https://github-readme-stats.vercel.app/api/top-langs/?username=kaelvex&layout=compact&theme=radical&hide_border=true&bg_color=0a0e1a&title_color=00f0ff&text_color=b0c7e7&card_width=320" alt="Top Langs" width="42%" />
    </div>
    <div style="display: flex; flex-wrap: wrap; gap: 1.2rem; justify-content: center; margin: 1.2rem 0;">
        <img src="https://github-readme-streak-stats.herokuapp.com/?user=kaelvex&theme=dark&background=0a0e1a&border=00f0ff30&ring=00f0ff&fire=00f0ff&currStreakLabel=00f0ff" alt="GitHub Streak" width="48%" />
        <img src="https://github-readme-activity-graph.vercel.app/graph?username=kaelvex&theme=react-dark&bg_color=0a0e1a&color=00f0ff&line=00f0ff&point=6c8cff&hide_border=true&area=true&area_color=00f0ff20" alt="Activity Graph" width="48%" />
    </div>

    <!-- TROPHIES -->
    <div style="display: flex; justify-content: center; margin: 1rem 0;">
        <img src="https://github-profile-trophy.vercel.app/?username=kaelvex&theme=radical&no-frame=true&row=1&column=6&margin-w=12&margin-h=12&bg_color=0a0e1a&title_color=00f0ff&icon_color=00f0ff" alt="Trophies" width="100%" style="max-width: 700px;" />
    </div>

    <!-- SNAKE -->
    <div class="snake-container">
        <img src="https://github.com/kaelvex/kaelvex/blob/output/github-contribution-grid-snake.svg?raw=true" alt="Snake animation" width="100%" style="border-radius: 1.5rem;" />
        <div style="text-align: center; font-size: 0.7rem; color: #4a6a9a; margin-top: 4px;">⌨ contribution grid · snake</div>
    </div>

    <!-- REDES SOCIAIS -->
    <div class="cyber-border" style="margin-top: 2rem;">
        <span>◈ CONEXÕES</span>
    </div>
    <div class="social-links">
        <a href="#" target="_blank"><img src="https://img.shields.io/badge/-GitHub-181717?style=for-the-badge&logo=github&logoColor=white" alt="GitHub" style="height: 32px; border-radius: 20px;" /></a>
        <a href="#" target="_blank"><img src="https://img.shields.io/badge/-LinkedIn-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white" alt="LinkedIn" style="height: 32px; border-radius: 20px;" /></a>
        <a href="#" target="_blank"><img src="https://img.shields.io/badge/-Twitter-1DA1F2?style=for-the-badge&logo=twitter&logoColor=white" alt="Twitter" style="height: 32px; border-radius: 20px;" /></a>
        <a href="#" target="_blank"><img src="https://img.shields.io/badge/-YouTube-FF0000?style=for-the-badge&logo=youtube&logoColor=white" alt="YouTube" style="height: 32px; border-radius: 20px;" /></a>
        <a href="#" target="_blank"><img src="https://img.shields.io/badge/-Discord-5865F2?style=for-the-badge&logo=discord&logoColor=white" alt="Discord" style="height: 32px; border-radius: 20px;" /></a>
    </div>

    <!-- RODAPÉ -->
    <div class="footer-cyber">
        <div style="display: flex; justify-content: center; gap: 2rem; flex-wrap: wrap; margin-bottom: 0.8rem;">
            <span>⏣ <span style="color: #00f0ff;">kael_vex</span> · 2026</span>
            <span>⚡ <span style="color: #6c8cff;">JAVA_BACKEND_EDITION</span></span>
            <span>⎔ <span style="color: #b0c7e7;">built with ☕ &amp; ⚡</span></span>
        </div>
        <div style="font-size: 0.7rem; opacity: 0.6; letter-spacing: 0.1em;">
            <span>⟨ JARVIS · BACKEND ⟩</span>  <span style="margin: 0 8px;">•</span>  <span>sistema operacional · perfil</span>
        </div>
    </div>

</div>
</body>
</html>
