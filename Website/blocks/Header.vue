<template>
    <header>
        <nav class="container navbar">
            <nuxt-link to="/" class="logoImgContainer">
                <img class="logo" src="../static/icon.png" alt="ColourIT Logo">
                <span class="logoText">ColourIT</span>
            </nuxt-link>
            <ul class="linksContainer">
                <li>
                    <nuxt-link class="link" to="/">Home</nuxt-link>
                </li>
                <li>
                    <nuxt-link class="link" to="/team">Team</nuxt-link>
                </li>
                <li>
                    <nuxt-link class="link" to="/about">About</nuxt-link>
                </li>
                <li>
                    <defbtn to="/projects">Projects</defbtn>
                </li>
            </ul>
            <!-- <div class="collapse navbar-collapse align-items-center justify-content-end" id="collapsibleNavbar">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link active my-md-2 mx-2 active" href="index.html">Home</a>
                    </li>
                    <li class="nav-item ">
                        <a class="nav-link my-md-2 mx-2" href="team.html">Team</a>
                    </li>
                    <li class="nav-item ">
                        <a class="nav-link my-md-2 mx-2" href="about.html">About</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="projects.html"><div class="defbtn">Projects</div></a>
                    </li>
                </ul>
            </div> -->
        </nav>
    </header>
</template>

<script>
export default {

}
</script>