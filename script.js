const nodemailer = require("nodemailer")

// Configurações de conexão
const config = {
    host: "smtp.gmail.com",
    port: 587,
    user: "**********@gmail.com",
    pass: "**********"
}

// Configurando o Transportador do Email
const transportador = nodemailer.createTransport({
    host: config.host,
    port: config.port,
    secure: false,
    auth: {
        user: config.user,
        pass: config.pass
    },
    tls: {
        rejectUnauthorized: false
    }
})

const envio = transportador.sendMail({  
    subject: "Assunto do Email",
    from: "remete@gmail.com",
    to: "destinatario@gmail.com",
    html: `
    <div>
        <em>Lorem</em>, ipsum <strong>dolor</strong> sit amet consectetur adipisicing elit. Non doloribus vel cum quia quisquam sint dolorem quas a porro, totam, quidem amet fuga, <em>obcaecati</em> recusandae iste <em>eveniet</em> nihil illo aliquid.
        Cupiditate commodi <strong>exercitationem</strong>, eos nesciunt maxime dolores natus explicabo minus velit <em>laudantium</em> tempore provident suscipit voluptates, <strong>animi</strong> ipsa, doloribus culpa ea. Non maxime aliquid itaque amet ipsa iste harum sequi!
        Architecto mollitia optio, animi nostrum quidem <strong>culpa</strong> facere necessitatibus modi nobis excepturi dolores provident at eum <strong>accusamus</strong> quis beatae dignissimos <em>impedit</em> reiciendis eius laborum sequi enim consectetur. Nobis, pariatur deserunt.
    </div>
    <ul>
        <li>Elemento 1</li>
        <li>Elemento 2</li>
        <li>Elemento 3</li>
    </ul>
    `,
    // text: "Conteúdo do Email"
})

console.log(envio)