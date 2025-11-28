const q = id => document.getElementById(id);
const setMsg = (id, text, ok = true) => q(id).innerHTML = text ? `<span class="${ok ? 'ok' : 'err'}">${text}</span>` : '';

q('btnModuler').addEventListener('click', async () => {
    setMsg('modulMsg', '');
    const kurskod = q('kurskod').value.trim();
    if (!kurskod) { setMsg('modulMsg', 'Ange kurskod', false); return; }
    q('modul').innerHTML = '';
    try {
        const res = await fetch(`/epok/modul/${encodeURIComponent(kurskod)}`);
        if (!res.ok) throw new Error('Kunde inte hämta moduler');
        const data = await res.json();
        if (!Array.isArray(data) || data.length === 0) { setMsg('modulMsg', 'Inga moduler hittades', false); return; }
        data.forEach(row => {
            const [kod, ...rest] = row.split(' ');
            const namn = rest.join(' ');
            const opt = document.createElement('option');
            opt.value = kod;
            opt.textContent = `${kod} ${namn}`;
            q('modul').appendChild(opt);
        });
        setMsg('modulMsg', `Hämtade ${data.length} modul(er) för ${kurskod}`);
    } catch (e) {
        setMsg('modulMsg', e.message, false);
    }
});

q('btnPersnr').addEventListener('click', async () => {
    setMsg('pnrMsg', '');
    const anv = q('anv').value.trim();
    if (!anv) { setMsg('pnrMsg', 'Ange användarnamn', false); return; }
    try {
        const res = await fetch(`/itsstudent/personnummer/${encodeURIComponent(anv)}`);
        if (res.status === 404) { q('pnr').value = ''; setMsg('pnrMsg', 'Hittade inget personnummer för angivet användarnamn', false); return; }
        if (!res.ok) throw new Error('Fel vid hämtning av personnummer');
        const data = await res.json();
        q('pnr').value = (data.personnummer || '').trim();
        setMsg('pnrMsg', 'Personnummer hämtat');
    } catch (e) {
        setMsg('pnrMsg', e.message, false);
    }
});

q('btnRegistrera').addEventListener('click', async () => {
    setMsg('ladokMsg', '');
    const payload = {
        personnummer: q('pnr').value.trim(),
        kurskod: q('kurskod').value.trim(),
        modul: q('modul').value.trim(),
        datum: q('datum').value,
        betyg: q('betyg').value
    };
    if (!payload.personnummer || !payload.kurskod || !payload.modul || !payload.datum || !payload.betyg) {
        setMsg('ladokMsg', 'Fyll i alla fält och hämta personnummer först', false);
        return;
    }
    try {
        const res = await fetch('/ladok/resultat', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(payload)
        });
        const data = await res.json();
        if (!res.ok || data.status === 'hinder') {
            setMsg('ladokMsg', data.message || 'Registrering misslyckades', false);
        } else {
            setMsg('ladokMsg', 'Registrerad');
        }
    }
    catch (e) {
        setMsg('ladokMsg', e.message, false);
    }
});