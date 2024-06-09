import React, { useRef } from 'react';
import { TextField, Button, Typography, Container, Paper } from '@mui/material';
import emailjs from '@emailjs/browser';

const EmailContactForm = () => {
  /*const [objet, setObjet] = useState('');
  const [email, setEmail] = useState('');
  const [message, setMessage] = useState('');*/

  const form = useRef();

  const sendEmail = (e) => {
    e.preventDefault();

    emailjs
      .sendForm('service_fl1pnxk', 'template_dr9t18n', form.current, {
        publicKey: 'OKV_u0rgpU4Saddj9',
      })
      .then(
        () => {
          console.log('SUCCESS!');
        },
        (error) => {
          console.log('FAILED...', error.text);
        },
      );
  };

  return (
    <Container maxWidth="sm" sx={{display: 'flex', justifyContent: 'center', alignItems: 'center',minHeight:'100vh'}}>
      <Paper elevation={3} sx={{ padding: '20px', marginTop: '50px' }}>
        <Typography variant="p" gutterBottom>
          Si vous avez besoin d'assistance contactez-nous !
          Notre equipe vous repondra dans les plus bref delais.
        </Typography>
        <form ref={form} onSubmit={sendEmail}>
          
        <TextField
            label="Votre nom"
            fullWidth
            margin="normal"
            variant="outlined"
           
            name="user_name"
           
            required
          />
          <TextField
            label="Email"
            fullWidth
            margin="normal"
            variant="outlined"
          
            name="user_email"
           
            required
          />
          <TextField
            label="Objet"
            fullWidth
            margin="normal"
            variant="outlined"
           
            name="user_objet"
            
            required
          />
          <TextField
            label="Message"
            multiline
            rows={4}
            fullWidth
            margin="normal"
            variant="outlined"
            
            name="message"
            
            required
          />
          <Button type="submit" variant="contained" color="primary" fullWidth
           sx={{ marginTop: '20px',
                 background: 'linear-gradient(90deg, rgba(255,109,109,0.8688725490196079) 0%, rgba(255,184,27,1) 100%)', //linear-gradient(45deg, #FE6B8B 30%, #FF8E53 90%)
                  borderRadius: 3,
                  border: 0,
                  color: 'white',
                  height: 48,
                  padding: '0 30px',
                  boxShadow: '0 3px 5px 2px rgba(255, 105, 135, .3)' }}>
            Envoyer mail
          </Button>
        </form>
      </Paper>
    </Container>
  );
};

export default EmailContactForm;
